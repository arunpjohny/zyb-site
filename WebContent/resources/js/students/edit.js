$(function() {

	$.Class("zyb.students.edit.Main", {}, {
		init : function(el, options) {
			this.el = $(el);
			this.options = $.extend({}, options);

			this.el.on("click", ".form-actions .cancel", this
							.proxy("onCancelClick"));

			$("form", this.el).validate({
				rules : {
					name : {
						required : true
					},
					weight : {
						required : true,
						digits : true
					},
					description : {
						required : true
					},
					image : {
						required : this.options.student == 0,
						accept : "jpeg|jpg|gif|png"
					},
					messages : {
						image : {
							accept : "Allowed extensions are jpeg, jpg, gif and png"
						}
					}
				},
				submitHandler : this.proxy("submitHandler")
			});
		},

		submitHandler : function(form) {
			$(form).ajaxSubmit({
				url : ZtUtils.getContextPath() + "/admin/student/edit/"
						+ this.options.student,
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
			$(e.target).trigger("zyb-page-load", "/students");
		}
	});
});