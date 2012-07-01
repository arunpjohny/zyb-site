$(function() {

			$.Class("zyb.aboutus.personnel.Main", {}, {
						init : function(el, options) {
							this.el = $(el);
							this.options = $.extend({}, options);

							$(".personnel-add", this.el).on("click",
									this.proxy("onAddClick"));

							this.el.on("click", ".zyb-personnel .icon-edit",
									this.proxy("onEditClick"));

							this.el.on("click", ".zyb-personnel .icon-remove",
									this.proxy("onRemoveClick"));
						},

						onAddClick : function(e) {
							$(e.target).trigger(
									"zyb-page-load",
									"/admin/aboutus/personnel/"
											+ this.options.type + "/edit/0");
						},

						onEditClick : function(e) {
							var $target = $(e.target);
							var id = $target.closest(".zyb-personnel")
									.data("personnel");
							if (id) {
								$target.trigger("zyb-page-load",
										"/admin/aboutus/personnel/"
												+ this.options.type + "/edit/"
												+ id);
							}
						},

						onRemoveClick : function(e) {
							var $target = $(e.target);
							var id = $target.closest(".zyb-personnel")
									.data("personnel");
							if (id) {
								$.ajax({
									url : ZtUtils.getContextPath()
											+ "/admin/aboutus/personnel/"
											+ this.options.type + "/delete/"
											+ id
								}).done(this.proxy("onRemoveSuccess"));
							}
						},

						onRemoveSuccess : function(result) {
							if (result && result.id) {
								$(
										".zyb-personnel[data-personnel='"
												+ result.id + "']", this.el)
										.remove();
							}
						}
					});
		});