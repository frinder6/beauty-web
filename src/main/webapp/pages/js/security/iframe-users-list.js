/**
 * frinder_liu
 * 
 * @date 2015-04-28 22:06
 */

// 添加
var _add = function(){
	var url = _PATH('/common/forward/security.iframe-users-add.action');
	var options = {
		url : url,
		title : '添加用户'
	};
	_dialog(options);
};


// 删除
var _del = function(){
	var rows = $('#table_user').datagrid('getSelections');
	var sys = $.map(rows, function(row, i){
		if (row.isSys == 1){
			return row.isSys;
		}
	});
	if (sys.length > 0){
		layer.msg('去除系统级用户后再执行该操作！');
		return;
	}
	var ids = $.map(rows, function(row, i) {
		return row.id;
	}).join(',');
	if (ids.length == 0) {
		layer.msg('至少需要选择一行删除！');
		return;
	}
	$.messager.confirm('Confirm', '数据删除后无法恢复，确定删除？', function(yes) {
		if (yes) {
			var url = _PATH('/user/deletes.action');
			$.ajax({
				"type" : "get",
				"url" : url,
				"dataType" : "text",
				"data" : {
					ids : ids
				},
				"success" : function(msg) {
					$('#table_user').datagrid('reload');
					layer.msg(msg);
				},
				"error" : function(msg){
					layer.msg(msg);
				}
			});
		}
	});
};

// 关闭弹出框
var _close = function() {
	$('#model-dialog').dialog('close');
	$('#table_user').datagrid('reload');
};

// 搜索方法
var doSearch = function(v){
	$('#table_user').datagrid('load', {
		userName : v
	});
};

/**
 * 加载表格
 */
$(function() {
	// 加载表格
	$('#table_user').datagrid({
		url : _PATH('/user/query/page.action'),
		fit : true,
		fitColumns : true,
		pageSize : 20,
		method : 'POST'
	});
	
	/**
	 * 重置分页工具条
	 */
	_initPager($('#table_user'));

});

// 添加修改图标（列表）
var _oper = function(val, row) {
	return _EDIT.format(row.id) + '&nbsp;' + _MAN.format(row.id);
};

// 添加修改方法（列表图标）
var _FN_EDIT = function(e) {
	var id = $(e).attr('data-id');
	var url = _PATH('/common/forward/security.iframe-users-modify.action?param={0}');
	var options = {
		url : url.format(id),
		title : '修改资源'
	};
	_dialog(options);
};

var _FN_MAN = function(e) {
	var id = $(e).attr('data-id');
	var url = _PATH('/common/forward/security.iframe-users-manager.action?param={0}');
	var options = {
		title : '用户-角色管理',
		url : url.format(id),
		w : 700,
		h : 500
	};
	_dialog(options);
};