$(function() {

	$.Class("zyb.aboutus.personnel.edit.Main", {}, {
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
					designation : {
						required : true
					},
					order : {
						required : true,
						digits : true
					},
					image : {
						required : this.options.student == 0,
						accept : "jpeg|jpg|gif|png"
					},
					summary : {
						required : true,
						minlength : 50
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
				url : ZtUtils.getContextPath() + "/admin/aboutus/personnel/"
						+ this.options.type + "/edit/" + this.options.person,
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
			$(e.target).trigger("zyb-page-load",
					"/aboutus/personnel/" + this.options.type);
		}
	});
});