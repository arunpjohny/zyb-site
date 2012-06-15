$(function() {

	$.Class("zyb.main.careers.Main", {}, {
				init : function(el, options) {
					this.el = $(el);
					this.options = $.extend({}, options);

					this.elStudentCt = $(".student-info-ct", this.el);

					$(".scrollable", this.el).scrollable();

					$(".career-student", this.el).on("click", "img",
							this.proxy("onStudentClick"));

					$(".career-student img:eq(0)", this.el).trigger("click");

					$.templates("career-student", $(".career-student-tmpl",
									this.el)[0]);
				},

				onStudentClick : function(e) {

					var $target = $(e.target);
					var id = $target.data("studentid");
					if (!id) {
						return;
					}
					if (this.studentRequest) {
						this.studentRequest.abort();
					}

					this.studentRequest = $.ajax({
						url : ZtUtils.getContextPath() + "/careers/student/"
								+ id
					}).success(this.proxy("onStudentRequestSuccess"))
							.always(this.proxy("onStudentRequestComplete"));

				},

				onStudentRequestSuccess : function(result) {
					console.log(result);

					if (result) {
						$(".career-student img", this.el).removeClass("active");
						$(
								".career-student img[data-studentid='"
										+ result.id + "']", this.el)
								.addClass("active");

						this.elStudentCt
								.html($.render["career-student"](result));

					}
				},

				onStudentRequestComplete : function() {
					delete this.studentRequest;
				}
			});
});