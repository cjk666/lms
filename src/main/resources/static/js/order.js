
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
		    ,id: 'order'
		    ,method: 'post'
		    ,toolbar: '#toolbarDemo'
	    	,height: 'full-40'
		    ,cellMinWidth: 60
		    ,url: '/lms/order/queryByPage'
		    ,cols: [[
		    	   {type: 'checkbox', fixed: 'left'}
			      ,{field:'orderId', title:'订单号'}
			      ,{field:'sendName', title:'寄件人'}
			      ,{field:'sendPhone', title:'寄件人电话', width:100}
			      ,{field:'sendSite', title:'寄件地址', width:250}
			      ,{field:'receName', title:'收件人'}
			      ,{field:'recePhone', title:'收件人电话', width:100}
			      ,{field:'receSite', title:'收件地址', width:250}
			      ,{field:'remark', title:'备注'}
			      ,{field:'orderStatue', title:'订单状态', width:90}
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
			      var id = $('#id');
			      var sendPhone = $('#sendPhone');
			      var recePhone = $('#recePhone');
			      //执行重载
			      table.reload('order', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
			        ,where: {
			            orderId: id.val(),
			        	sendPhone: sendPhone.val(),
			        	recePhone: recePhone.val()
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
	    var checkStatus = table.checkStatus('order');
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
					ids += data[i].orderId+',';
				}
		        layer.confirm('真的删除'+data.length+'条数据么',function(){
		        	$.ajax({
			        	url:"/lms/order/deleteMore?ids="+ids,
			        	type:'post',
			        	dataType:'json',
			        	success : function(data) {
							if (data.statue == 0) {
								layer.close(layer.index);
								layer.msg(data.msg);
								table.reload('order');
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
				url : "/lms/order/" + url,
				type : "POST",
				data : data.field,
				dataType : 'json',
				success : function(data) {
					if (data.statue == 0) {
						layer.close(layer.index);
						layer.msg(data.msg);
						table.reload('order');
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
							url : "/lms/order/deleteById?id="+data.orderId,
							type : "POST",
							dataType : 'json',
							success : function(data) {
								if (data.statue == 0) {
									layer.close(layer.index);
									layer.msg(data.msg);
									table.reload('order');
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
		    		"orderId" : data.orderId,
					"sendSite" : data.sendSite,
					"receSite" :data.receSite,
					"sendName" :data.sendName,
					"sendUnit" :data.sendUnit,	
					"sendPhone" :data.sendPhone,	
					"receName" :data.receName,	
					"receUnit" :data.receUnit,	
					"recePhone" :data.recePhone,	
					"orderStatue" :data.orderStatue,	
					"remark" :data.remark
				});
				title = "编辑数据	";
				url = "update";
				openDialog();
		    }
		  });
		});
});
 

