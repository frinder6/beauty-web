/**
 * frinder_liu
 * 
 * @date 2015-04-28 22:06
 */
(function($) {
	'use strict';

	var defaults = {
		vnid : '#id',
		contentId : '#cid',
		data : [],
		url : '',
		params : {}
	};

	// 水平菜单
	var _ha = '<a class="linkbutton" href="javascript:void(0)" data-id="{0}">{1}</a>';
	
	// 垂直导航
	var _div = '<div id="easyui-menu-self" class="easyui-menu" data-options="inline:true" style="width:100%;height:100%;">{0}</div>';

	// 子菜单
	var _menu = '<div data-id="{0}" data-url="{1}" data-value="{2}" class="click-class">{3}</div><div class="menu-sep"></div>';

	// hnav 水平导航
	var vnav, hnav;
	
	var index = 0;

	$.fn.vnav = function(options) {
		var settings = $.extend({}, defaults, options);
		// 作为全局变量使用
		vnav = $(this);
		// 初始化html元素
		vnav.empty();

		// 获取后台数据
		$.ajax({
			type : "POST",
			url : settings.url,
			data : settings.params,
			dataType : "json",
			success : function(data) {
				settings.data = data;
				var menus = $.map(data, function(v, i) {
					return _menu.format(v.id, v.resourceValue, v.resourceName, v.resourceName);
				}).join('');
				vnav.append(_div.format(menus));
				// 重置menu
				$('#easyui-menu-self').menu();
				// 垂直菜单单击事件
				$('#easyui-menu-self').find('.click-class').on('click', function(){
					// 添加背景色
					$('#easyui-menu-self').find('.click-class').removeClass('l-btn-plain-selected');
					$(this).addClass('l-btn-plain-selected');
					_IFRAME($(this).attr('data-url'));
				});
			}
		});
	};

	// 水平导航
	$.fn.hnav = function(options) {
		var settings = $.extend({}, defaults, options);
		hnav = $(this);
		hnav.empty();
		// 获取后台数据
		$.ajax({
			type : "POST",
			url : settings.url,
			data : settings.params,
			dataType : "json",
			success : function(data) {
				settings.data = data;
				// 获取主内容块id
				var cid = settings.contentId;
				// 添加  hnav a
				for ( var i in data) {
					var v = data[i];
					hnav.append(_ha.format(v.id, v.resourceName));
				}
				// 将 a 转化为 easyui-linkbutton
				hnav.find('.linkbutton').linkbutton({
					width : 100,
					height : 50,
					toggle : true,
					size : 'large',
					group : 'hnav-btn',
					plain : true
				});
				// 默认选中第一个
				hnav.find('.linkbutton').eq(0).linkbutton({
					selected : true
				});
				// 添加事件
				hnav.find('.linkbutton').on('click', function() {
					_IFRAME('/pages/content.html');
					// 加载垂直菜单
					loadVnav({
						id : settings.vnid,
						contentId : cid,
						pid : $(this).attr('data-id')
					});
				});
				// 加载垂直菜单
				loadVnav({
					id : settings.vnid,
					contentId : cid,
					pid : hnav.find('a').eq(0).attr('data-id')
				});
			}
		});
	};
	
	// 加载vnav
	function loadVnav(opts){
		$(opts.id).vnav({
			url : _PATH('/resource/load/menu.action'),
			contentId : opts.contentId,
			params : {
				level : 3,
				parentId : opts.pid,
				type : 3
			}
		});
	};

})(jQuery);