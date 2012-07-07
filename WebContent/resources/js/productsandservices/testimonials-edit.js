$(function() {

	$.Class("zyb.main.productsandservices.testimonials.edit.Main", {}, {
				init : function(el, options) {
					this.el = $(el);
					this.options = $.extend({}, options);

					this.elForm = $("form.testimonial-edit", this.el);
					this.elForm.validate({
								rules : {
									order : {
										required : true,
										digits : true
									},
									name : {
										required : true,
										maxlength : 200
									},
									company : {
										required : true,
										maxlength : 200
									},
									designation : {
										required : true,
										maxlength : 200
									},
									image : {
										required : this.options.testimonial == 0,
										accept : "jpeg|jpg|gif|png"
									},
									description : {
										required : true,
										minlength : 50
									},
									testimonial : {
										required : true
									}
								}
							});
					$(".save", this.elForm).on("click",
							this.proxy("onSaveClick"));
					$(".cancel", this.elForm).on("click",
							this.proxy("onCancelClick"));
				},

				onSaveClick : function(e) {
					e.preventDefault();
					e.stopPropagation();
					if (this.elForm.valid()) {
						this.elForm.ajaxSubmit({
									data : {
										"x-requested-with" : "XMLHttpRequest"
									},
									validator : {
										form : this.elForm
									}
								});
					}
				},

				onCancelClick : function(e) {
					$(e.target).trigger("zyb-page-load",
							"/productsandservices/testimonials");
				}
			});
});