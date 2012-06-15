$(function() {

			$.Class("zyb.main.contactus.Main", {}, {
						init : function(el, options) {
							this.el = $(el);
							this.options = $.extend({}, options);

							this.$form = $("form", this.el);

							this.$formValidator = this.$form.validate({
										rules : {
											from : {
												required : true,
												email : true
											},
											subject : {
												required : true
											},
											body : {
												required : true
											}
										}
									});

							$(".send-mail", this.$form).on("click",
									this.proxy("onSendMailClcik"));
							$(".cancel-mail", this.$form).on("click",
									this.proxy("onCancelMailClcik"));
						},

						onSendMailClcik : function(e) {
							if (!this.$form.valid()) {
								return;
							}

							$.ajax({
								url : ZtUtils.getContextPath()
										+ "/contactus/mail",
								data : this.$form.serialize(),
								type : "POST"
							}).done(this.proxy("onSendMailSuccess"));
						},

						onSendMailSuccess : function() {
							this.$form.resetForm();
							this.$formValidator.resetForm();
						},

						onCancelMailClcik : function(e) {
							this.$form.resetForm();
							this.$formValidator.resetForm();
						}
					});
		});