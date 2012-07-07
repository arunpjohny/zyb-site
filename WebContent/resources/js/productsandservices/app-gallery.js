$(function() {

			$.Class("zyb.main.productsandservices.appsgallery.Main", {}, {
						init : function(el, options) {
							this.el = $(el);
							this.options = $.extend({}, options);

							this.btnAdd = $(".application-add", this.el).on(
									"click", this.proxy("onAddClick"));
						},

						onAddClick : function(e) {
							e.preventDefault();
							e.stopPropagation();
							$(e.target)
									.trigger("zyb-page-load",
											"/admin/productsandservices/app-gallery/edit/0");
						}
					});
		});