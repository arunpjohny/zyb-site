$(function() {

	$.Class("zyb.main.students.Main", {}, {
				init : function(el, options) {
					this.el = $(el);
					this.options = $.extend({}, options);

					this.elStudentCt = $(".info-ct", this.el);

					$(".scrollable", this.el).scrollable();

					$(".student", this.el).on("click", "img",
							this.proxy("onStudentClick"));

					$(".student img:eq(0)", this.el).trigger("click");

					$.templates("student", $(".student-tmpl", this.el)[0]);

					$(".student-add", this.el).on("click",
							this.proxy("onStudentAddClick"));

					this.el.on("click", "article.student .icon-edit", this
									.proxy("onStudentEditClick"));

					this.el.on("click", "article.student .icon-remove", this
									.proxy("onStudentRemoveClick"));
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
								url : ZtUtils.getContextPath() + "/student/"
										+ id
							}).success(this.proxy("onStudentRequestSuccess"))
							.always(this.proxy("onStudentRequestComplete"));

				},

				onStudentRequestSuccess : function(result) {
					if (result) {
						$(".student img", this.el).removeClass("active");
						$(".student img[data-studentid='" + result.id + "']",
								this.el).addClass("active");

						this.elStudentCt.html($.render["student"](result));

					}
				},

				onStudentRequestComplete : function() {
					delete this.studentRequest;
				},

				onStudentAddClick : function(e) {
					$(e.target).trigger("zyb-page-load",
							"/admin/student/edit/0");
				},

				onStudentEditClick : function(e) {
					var $target = $(e.target);
					var id = $target.closest("article.student").data("student");
					if (id) {
						$target.trigger("zyb-page-load", "/admin/student/edit/"
										+ id);
					}
				},

				onStudentRemoveClick : function(e) {
					var $target = $(e.target);
					var id = $target.closest("article.student").data("student");
					if (id) {
						$.ajax({
							url : ZtUtils.getContextPath()
									+ "/admin/student/delete/" + id
						}).done(this.proxy("onStudentRemoveSuccess"));
					}
				},

				onStudentRemoveSuccess : function(result) {
					if (result && result.id) {
						var imgs = $(".scrollable img[data-studentid]", this.el);
						var img = imgs.filter("[data-studentid=" + result.id
								+ "]");
						var index = imgs.index(img);
						var nextIndex = imgs.length > index + 1
								? index + 1
								: imgs.length > 1 ? index - 1 : -1;
						if (nextIndex > -1) {
							imgs.eq(nextIndex).trigger("click");
						} else {
							this.elStudentCt.empty();
						}
						img.remove();
					}
				}
			});
});