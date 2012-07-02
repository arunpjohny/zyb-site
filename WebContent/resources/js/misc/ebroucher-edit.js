$(function() {

			$.Class("zyb.misc.broucher.edit.Main", {}, {
						init : function(el, options) {
							this.el = $(el);
							this.options = $.extend({}, options);

							this.el.on("click", ".form-actions .cancel", this
											.proxy("onCancelClick"));

							$("form", this.el).validate({
										rules : {
											broucher : {
												required : true
											},
											order : {
												required : true,
												digits : true
											},
											file : {
												required : this.options.broucher == 0
											}
										},
										submitHandler : this
												.proxy("submitHandler")
									});
						},

						submitHandler : function(form) {
							$(form).ajaxSubmit({
								url : ZtUtils.getContextPath()
										+ "/admin/ebroucher/edit/"
										+ this.options.broucher,
								data : {
									"x-requested-with" : "XMLHttpRequest"
								},
								validator : {
									form : $(form)
								}
							});
							return false;
						},

						onCancelClick : function(e) {
							$(e.target).trigger("zyb-page-load", "/ebroucher");
						}
					});
		});