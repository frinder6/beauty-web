/**
 * 权限
 */
/**
 * 保存用户权限
 */
_AUTHS = [];

/**
 * 加载用户权限
 */
var _LOAD_AUTHS = function() {
	if (_AUTHS.length == 0) {
		var url = _PATH('/user/log/user/auths.action');
		$.ajax({
			"type" : "get",
			"url" : url,
			"dataType" : 'json',
			"async" : false,
			"success" : function(data) {
				_AUTHS = data;
			},
			"error" : function(msg) {
				layer.msg(msg);
			}
		});
	}
};

/**
 * 判断是否拥有权限
 */
var _HAVE_RIGHT = function(v) {
	var len = $.inArray(v, _AUTHS);
	return len == -1 ? false : true;
};

/**
 * 删除没有权限的操作
 */
var _REMOVE_NO_RIGHT_OPERS = function() {
	var needs = $('.auth');
	if (needs){
		$.each(needs, function(i, e) {
			var auth = $(e).attr('data-auth');
			if (!_HAVE_RIGHT(auth)) {
				$(e).remove();
			}
		});
	}
};


$(function(){
	/**
	 * 初始化没有权限的操作
	 */
	_REMOVE_NO_RIGHT_OPERS();
});