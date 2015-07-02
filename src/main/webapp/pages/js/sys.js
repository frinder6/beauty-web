/**
 * format方法
 */
String.prototype.format = function() {
	var s = this, i = arguments.length;

	while (i--) {
		s = s.replace(new RegExp('\\{' + i + '\\}', 'gm'), arguments[i]);
	}
	return s;
};


//弹出框
var _dialog = function(options) {
	var w = options.w | 550;
	var h = options.h | 450;
	$('#model-dialog').dialog({
		title : options.title,
		width : w,
		height : h,
		cache : false,
		href : options.url,
		modal : true
	});
};

/**
 * 关闭弹出框，不刷新
 */
var _close_nf = function(){
	$('#model-dialog').window('close');
}

/**
 * 为指定 url添加根
 * 
 * @param url
 * @returns {String}
 */
_PATH = function(url) {
	return _GLOGAL_PATH + url;
};

/**
 * 切换 iframe
 * 
 * @param url
 */
_IFRAME = function(url) {
	$('.main-iframe').attr('src', _PATH(url));
};

/**
 * 子页面切换父页面 iframe
 * 
 * @param url
 */
_PARENT_IFRAME = function(url) {
	$(window.parent.document).find('.main-iframe').attr('src', _PATH(url));
};

/**
 * 表格使用图标
 */
var _ADD = '<a class="icon icon-add" data-id="{0}" onclick="_FN_ADD(this)"></a>';
var _DEL = '<a class="icon icon-remove" data-id="{0}" onclick="_FN_DEL(this)"></a>';
var _EDIT = '<a class="icon icon-edit" data-id="{0}" onclick="_FN_EDIT(this)"></a>';
var _DETAIL = '<a class="icon icon-search" data-id="{0}" onclick="_FN_DETAIL(this)"></a>';
var _MAN = '<a class="icon icon-man" data-id="{0}" onclick="_FN_MAN(this)"></a>';
/**
 * 转换表格的特定值
 */
var _SYS_ENABLE_FORMATER = function(value, row, index) {
	if (value == 1) {
		return '是';
	} else {
		return '否';
	}
};

/**
 * 初始化分页工具条
 */
var _pager = function(pager) {
	pager.pagination({
		beforePageText : '第',
		afterPageText : '页 / 共 {pages} 页',
		displayMsg : '从第 {from} 到 {to} 第，共 {total} 条'
	});
};

var _initPager = function(table){
	var pager = table.datagrid('getPager');
	_pager(pager);
};

var _linkPagebar = {
	layout : [ 'links' ],
	displayMsg : ''
};

/**
 * 通用提交重置方法
 */
// 提交
function submitForm() {
	var validate = $('#basicForm').form('enableValidation').form('validate');
	if (validate) {
		$('#basicForm').ajaxSubmit(function(msg) {
			layer.msg(msg);
			_close();
		});
	}
};

// 重置
function clearForm() {
	$('#basicForm').form('clear');
};