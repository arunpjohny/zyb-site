$(function() {

			$.Class("zyb.students.edit.Main", {}, {
						init : function(el, options) {
							this.el = $(el);
							this.options = $.extend({}, options);

							$("form", this.el).validate({
								rules : {
									name : {
										required : false
									},
									description : {
										required : false
									},
									image : {
										required : false
									}
								},
								submitHandler : function(form) {
									$(form).ajaxSubmit({
										url : ZtUtils.getContextPath()
												+ "/admin/student/edit/0",
										data : {
											"x-requested-with" : "XMLHttpRequest"
										}
									});
									return false;
								}
							});
						}
					});
		});