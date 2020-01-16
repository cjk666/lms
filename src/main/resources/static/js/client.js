
var url;
var title;
layui.use([ 'jquery', 'table', 'layer', 'form', 'laydate' ],
	function(){
		layer = layui.layer;
		var table = layui.table;
		var form = layui.form;
		var laydate = layui.laydate;
		$ = layui.$;
		
		//日期
		  laydate.render({
		    elem: '#date'
		  });
		  laydate.render({
		    elem: '#date1'
		  });
		
	//方法级渲染
	  table.render({
		    elem: '#test'
		    ,id: 'client'
		    ,method: 'post'
		    ,toolbar: '#toolbarDemo'
	    	,height: 'full-40'
		    ,cellMinWidth: 60
		    ,url: '/lms/client/queryByPage'
		    ,cols: [[
		    	   {type: 'checkbox', fixed: 'left'}
			      ,{field:'id', title:'主键编号',hidd:false}
			      ,{field:'name', title:'客户姓名'}
			      ,{field:'phone', title:'客户电话'}
			      ,{field:'address', title:'客户地址', width:100}
			      ,{field:'unit', title:'客户单位', width:250}
			      ,{field:'orderId', title:'订单编号'}
			      ,{field:'createTime', title:'创建时间', width:170}
			      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
		    ]]
		    ,page: true
		    ,limit: 20
		    ,toolbar: '#toolbarDemo'
	  });
		
	  //模糊查询表格重载
	  active = {
			    reload: function(){
			      var name = $('#name');
			      var phone = $('#phone');
			      var username = $('#username');
			      //执行重载
			      table.reload('client', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			        	name: name.val(),
			        	phone: phone.val(),
			        	username: username.val()
			        }
			      }, 'data');
			    }
		};
	  $('.demoTable .layui-btn').on('click', function(){
		  var type = $(this).data('type');
		  active[type] ? active[type].call(this) : '';
	  });
			  
	  
	//工具栏事件
	  table.on('toolbar(test)', function(obj){
		  var checkStatus = table.checkStatus('client');
		var data = checkStatus.data; 
	    switch(obj.event){
	      case 'add':
	    	  openDialog();
	    	  url='add';
	    	  title='新增订单';
	    	  $("button[type='reset']").trigger("click");//清空表单
	      break;
	      case 'deleteMore':
	    	  if (data.length == 0) {
	    		  layer.msg('请选择数据');
	    		  return;
	    	  }
		    	var ids = '';
		        for (var i = 0; i < data.length; i++) {
					ids += data[i].id+',';
				}
		        layer.confirm('真的删除'+data.length+'条数据么',function(){
		        	$.ajax({
			        	url:"/lms/client/deleteMore?ids="+ids,
			        	type:'post',
			        	dataType:'json',
			        	success : function(data) {
							if (data.statue == 0) {
								layer.close(layer.index);
								layer.msg(data.msg);
								table.reload('client');
							} else {
								layer.msg(data.msg);
							}
						}
			        });
		        });
		        
	      break;
	      case 'check':
	    	  
	      break;
	    };
	  });
	
	  //打开窗口
	  function openDialog() {
			// 显示更新学生表单的弹出层
			layer.open({
				type : 1,
				title : title,
				skin : 'layui-layer-molv',
				area : [ '600px' ],
				content : $('#user-layer')
			});
		}
	// 添加表单提交
		form.on('submit(save_form)',function(data) {
			// ajax方式添加学生
			$.ajax({
				url : "/lms/client/" + url,
				type : "POST",
				data : data.field,
				dataType : 'json',
				success : function(data) {
					if (data.statue == 0) {
						layer.close(layer.index);
						layer.msg(data.msg);
						table.reload('client');
					} else {
						layer.msg(data.msg);
					}
				},
				error : function() {
					console.log("ajax error");
				}
			});
			// 阻止表单跳转
			return false;
		});
	//监听行单击事件（双击事件为：rowDouble）
	  table.on('row(test)', function(obj){
	    //标注选中样式
	    obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
	  });
	  
	  
	  //操作栏事件
	  layui.use('table', function(){
		  var table = layui.table;
		  //监听表格复选框选择
		  table.on('checkbox(test)', function(obj){
		    console.log(obj)
		  });
		  //监听工具条
		  table.on('tool(test)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			        //obj.del();
			        //location.href = '/admin/deleteById?id='+data.id;
			        $.ajax({
							url : "/lms/client/deleteById?id="+data.id,
							type : "POST",
							dataType : 'json',
							success : function(data) {
								if (data.statue == 0) {
									layer.close(layer.index);
									layer.msg(data.msg);
									table.reload('client');
								} else {
									layer.msg('删除失败,'+data.msg);
								}
							},
							error : function() {
								console.log("ajax error");
							}
						});
			      });
		    } else if(obj.event === 'edit'){
		    	form.val('form', {
		    		"id" : data.id,
					"name" : data.name,
					"phone" :data.phone,	
					"address" :data.address,	
					"unit" :data.unit,	
					"orderId" :data.orderId	
				});
				title = "编辑数据	";
				url = "update";
				openDialog();
		    }
		  });
		});
});
 

