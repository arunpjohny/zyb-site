$(function() {

	$.Class("zyb.misc.mailer.Main", {}, {
		init : function(el, options) {
			this.el = $(el);
			this.options = $.extend({}, options);

			this.$form = $("form", this.el);

			$(".mailer-type", this.$form).zybcombobox({
						name : "type",
						source : [{
									id : "SIMPLE",
									description : "Combined mail"
								}, {
									id : "INDIVIDUAL",
									description : "Mail per individual person"
								}],
						select : this.proxy("onTypeSelect")
					});

			var _self = this;
			$.validator.addMethod("mailer-html-plain", function(value, element,
							param) {
						return $("[name='plain']", _self.$form).val()
								|| $("[name='html']", _self.$form).val();
					});

			this.$formValidator = this.$form.validate({
				rules : {
					type : {
						required : true
					},
					source : {
						required : true
					},
					subject : {
						required : true
					},
					plain : {
						"mailer-html-plain" : true
					},
					html : {
						"mailer-html-plain" : true
					}
				},
				messages : {
					plain : {
						"mailer-html-plain" : "Both plain and html contents cannot be blank."
					},
					html : {
						"mailer-html-plain" : "Both plain and html contents cannot be blank."
					}
				}
			});

			$(".send-mail", this.$form).on("click",
					this.proxy("onSendMailClcik"));
			$(".cancel-mail", this.$form).on("click",
					this.proxy("onCancelMailClcik"));
		},

		onTypeSelect : function(e, type) {
			if (type.id == "INDIVIDUAL") {
				$("input[name='fields']", this.$form).closest(".control-group")
						.show();
			} else {
				$("input[name='fields']", this.$form).closest(".control-group")
						.hide();
			}
		},

		onSendMailClcik : function(e) {
			if (!this.$form.valid() || this._mailing_in_progress) {
				return;
			}

			$(".form-actions .btn", this.$form).addClass("disabled");
			this._mailing_in_progress = true;

			this.$form.ajaxSubmit({
						url : ZtUtils.getContextPath() + "/mailer",
						timeout : 900000,
						data : {
							"x-requested-with" : "XMLHttpRequest"
						},
						type : "POST",
						validator : {
							form : this.$form
						},
						success : this.proxy("onSendMailSuccess"),
						error : this.proxy("onSendMailError")
					});
		},

		onSendMailSuccess : function() {
			this.onSendMailComplete();
		},

		onSendMailError : function() {
			this.onSendMailComplete();
		},

		onSendMailComplete : function() {
			$(".form-actions .btn", this.$form).removeClass("disabled");
			this._mailing_in_progress = false;
		},

		onCancelMailClcik : function(e) {
			this.$form.resetForm();
			this.$formValidator.resetForm();
		}
	});
});