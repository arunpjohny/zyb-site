$(function() {

			$.Class("zyb.main.home.Main", {}, {
						init : function(el, options) {
							this.el = $(el);
							this.options = $.extend({}, options);

							//$(".nivoSlider",this.el).nivoSlider();
						}
					});
		});