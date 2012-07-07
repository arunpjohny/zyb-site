$(function() {

	$.Class("zyb.main.productsandservices.appsgallery.edit.Main", {}, {
				init : function(el, options) {
					this.el = $(el);
					this.options = $.extend({}, options);

					this.elForm = $("form.application-edit", this.el).modal({
								show : false
							});
					this.elForm.validate({
								rules : {
									order : {
										required : true,
										digits : true
									},
									caption : {
										required : true,
										maxlength : 20
									},
									application : {
										required : this.options.application == 0
									},
									image : {
										required : this.options.application == 0,
										accept : "jpeg|jpg|gif|png"
									},
									description : {
										required : true,
										minlength : 50
									},
									breif : {
										required : true,
										maxlength : 200
									},
									image : {
										accept : "jpeg|jpg|png"
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

				onCancelClick : function() {
					$(e.target).trigger("zyb-page-load",
							"/productsandservices/app-gallery");
				}
			});
});