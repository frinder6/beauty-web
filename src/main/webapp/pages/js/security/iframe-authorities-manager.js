/**
 * frinder_liu
 * 
 * @date 2015-05-18
 */
var save = function() {
	var table = $('#table_resource_selected');
	var data = table.datagrid('getData');
	var inserts = $.map(data.rows, function(row, i) {
		return row.id;
	}).join(',');
	$.ajax({
		"type" : "get",
		"url" : _PATH('/authority/reset/auth.action'),
		"dataType" : "text",
		"data" : {
			authorityid : authorityid,
			inserts : inserts
		},
		"success" : function(msg) {
			$('#table_resource_all').datagrid('reload');
			table.datagrid('reload');
			layer.msg(msg);
			setTimeout(function() {
				_close_nf();
			}, 2000);
		},
		"error" : function(msg) {
			layer.msg(msg);
		}
	});
};

var add_toolbar = [ {
	text : '添加',
	iconCls : 'icon-add',
	handler : function() {
		var table1 = $('#table_resource_all');
		var table2 = $('#table_resource_selected');
		var rows = table1.datagrid('getSelections');
		$.each(rows, function(i, row) {
			var idx = table1.datagrid('getRowIndex', row);
			table1.datagrid('deleteRow', idx);
			table2.datagrid('insertRow', {
				index : 0,
				row : row
			});
		});
	}
} ];

var del_toolbar = [ {
	text : '删除',
	iconCls : 'icon-remove',
	handler : function() {
		var table2 = $('#table_resource_all');
		var table1 = $('#table_resource_selected');
		var rows = table1.datagrid('getSelections');
		$.each(rows, function(i, row) {
			var idx = table1.datagrid('getRowIndex', row);
			table1.datagrid('deleteRow', idx);
			table2.datagrid('insertRow', {
				index : 0,
				row : row
			});
		});
	}
} ];

$(function() {
	var url = _PATH('/authority/query/id.action?id={0}');
	$('#basicForm').form('load', url.format(authorityid));

	$('#table_resource_all').datagrid({
		url : _PATH('/authority/query/res/table.action'),
		queryParams : {
			authorityid : authorityid,
			selected : false,
			sortColumn : 'parent_id asc,'
		},
		fit : true,
		fitColumns : true,
		method : 'POST'
	});

	/**
	 * 重置分页工具条
	 */
	// var pager1 = $('#table_resource_all').datagrid().datagrid('getPager');
	// pager1.pagination(_linkPagebar);
	$('#table_resource_selected').datagrid({
		url : _PATH('/authority/query/res/table.action'),
		queryParams : {
			authorityid : authorityid,
			selected : true,
			sortColumn : 'parent_id asc,'
		},
		fit : true,
		fitColumns : true,
		method : 'POST'
	});

	/**
	 * 重置分页工具条
	 */
	// var pager2 =
	// $('#table_resource_selected').datagrid().datagrid('getPager');
	// pager2.pagination(_linkPagebar);
});