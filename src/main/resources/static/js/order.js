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
		
		table.render({
		    elem: '#test'
		    ,id: 'order'
		    ,url:'/lms/order/queryByPage'
		    ,method: 'post'
		    ,toolbar: '#toolbarDemo'
		    ,title: '用户数据表'
		    ,totalRow: true
		    ,cellMinWidth: 10
		    ,cols: [[
		       {type: 'checkbox', fixed: 'left'}
		      ,{field:'orderId', title:'订单号'}
		      ,{field:'sendSite', title:'发货地址'}
		      ,{field:'receSite', title:'收货地址'}
		      ,{field:'sendName', title:'发货人'}
		      ,{field:'sendUnit', title:'发货单位'}
		      ,{field:'sendPhone', title:'发货人电话'}
		      ,{field:'sendDate', title:'发货日期'}
		      ,{field:'receName', title:'收货人'}
		      ,{field:'receUnit', title:'收货单位'}
		      ,{field:'recePhone', title:'收货人电话'}
		      ,{field:'totalFee', title:'总计费用'}
		      ,{field:'remark', title:'备注'}
		      ,{field:'createTime', title:'创建时间'}
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
		    ]]
		    ,page: true
		    ,limit: 20
		  })
	  
	  //工具栏事件
	  table.on('toolbar(test)', function(obj){
	    var checkStatus = table.checkStatus('user');
	    var data = checkStatus.data;
	    switch(obj.event){
	    //添加数据
	      case 'add':
			title = "新增数据";
			url = "add";
			openDialog();
	        break;
	    //批量添加
	      case 'addMore':
			url = "addMore";
			layui.msg('addMore');
			openDialog();
	        break;
	    //批量删除
	      case 'deleteMore':
			url = "deleteMore";
			layui.msg('批量删除');
	        break;
	   //分配角色
	      case 'saveRole':
			url = "saveRole";
			layer.msg(data[0].id);
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
		form.on('submit(save_form)',
				function(data) {
					// ajax方式添加学生
					$.ajax({
						url : "/lms/order/" + url,
						type : "POST",
						data : data.field,
						// contentType: 'application/json',
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
								obj.del();
							} else {
								layer.msg('删除失败,'+data.msg);
							}
						},
						error : function() {
							console.log("ajax error");
						}
					});
		      });
		      table.reload('test');
		    } else if(obj.event === 'edit'){
		    	form.val('form', {
		    		"orderId" : data.orderId,
					"sendSite" : data.sendSite,
					"receSite" :data.receSite,
					"sendName" :data.sendName,
					"sendUnit" :data.sendUnit,	
					"sendPhone" :data.sendPhone,	
					"sendDate" :data.sendDate,	
					"receName" :data.receName,	
					"receUnit" :data.receUnit,	
					"recePhone" :data.recePhone,	
					"totalFee" :data.totalFee,	
					"remark" :data.remark
				});
				title = "编辑数据	";
				url = "update";
				openDialog();
		    }
		  });
		});
});
 

