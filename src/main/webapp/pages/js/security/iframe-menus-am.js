/**
 * frinder_liu
 * 
 * @date 2015-05-10
 */
$(function() {

	var url = _PATH('/resource/load/combo.action');
	$('#select_parentId').combobox({
		url : url,
		method : 'get',
		valueField : 'id',
		textField : 'resourceName',
		groupField : 'parentName',
		panelHeight : 'auto',
		queryParams : {
			type : 3,
			level : 2,
			sortColumn : 'parent_id asc,'
		},
		onSelect : function(row) {
			var level = Number(row.level) + 1;
			$('#level_num').numberspinner('setValue', level);
		}
	});
	
	
});