/**
 * frinder_liu
 * 
 * @date 2015-04-28 22:06
 */

// 添加
var _add = function(){
	var url = _PATH('/common/forward/security.iframe-menus-add.action');
	var options = {
		url : url,
		title : '添加菜单'
	};
	_dialog(options);
};

//弹出框
var _dialog = function(options) {
	$('#model-dialog').dialog({
		title : options.title,
		width : 550,
		height : 550,
		cache : false,
		href : options.url,
		modal : true
	});
};


// 删除
var _del = function(){
	var rows = $('#table_menu').datagrid('getSelections');
	var sys = $.map(rows, function(row, i){
		if (row.isSys == 1){
			return row.isSys;
		}
	});
	if (sys.length > 0){
		layer.msg('去除系统级菜单后再执行该操作！');
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
			var url = _PATH('/resource/deletes.action');
			$.ajax({
				"type" : "get",
				"url" : url,
				"dataType" : "text",
				"data" : {
					ids : ids
				},
				"success" : function(msg) {
					$('#table_menu').datagrid('reload');
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
	$('#table_menu').datagrid('reload');
};

// 搜索方法
var doSearch = function(v){
	$('#table_menu').datagrid('load', {
		type : 3,
		resourceName : v
	});
};


/**
 * 加载表格
 */
$(function() {
	// 加载表格
	$('#table_menu').datagrid({
		url : _PATH('/resource/query/page.action'),
		queryParams : {
			type : 3,
			sortColumn : 'parent_id asc,'
		},
		fit : true,
		fitColumns : true,
		pageSize : 20,
	});
	
	
	/**
	 * 重置分页工具条
	 */
	_initPager($('#table_menu'));

});

// 添加修改图标（列表）
var _oper = function(val, row) {
	return _EDIT.format(row.id);
};

// 添加修改方法（列表图标）
var _FN_EDIT = function(e) {
	var id = $(e).attr('data-id');
	var url = _PATH('/common/forward/security.iframe-menus-modify.action?param={0}');
	var options = {
		url : url.format(id),
		title : '修改菜单'
	};
	_dialog(options);
};

var _FN_DETAIL = function(e) {
	alert($(e).attr('data-id'));
};