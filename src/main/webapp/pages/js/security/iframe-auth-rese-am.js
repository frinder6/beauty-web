/**
 * frinder_liu
 * 
 */
$(function() {

	$('#select_group').combobox({
		url : _PATH('/argroup/query/combo.action'),
		method : 'get',
		valueField : 'id',
		textField : 'groupName',
		panelHeight : 'auto',
		queryParams : {
			rows : 10000
		},
		onSelect : function(row) {
			$('input[name="groupName"]').val(row.groupName);
		}
	});
	
});