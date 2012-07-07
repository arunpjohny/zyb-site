$(function() {

	$.Class("zyb.main.productsandservices.testimonials.Main", {}, {
		init : function(el, options) {
			this.el = $(el);
			this.options = $.extend({}, options);

			this.btnAdd = $(".testimonial-add", this.el).on("click",
					this.proxy("onAddClick"));

			this.tmpls = {
				tmplList : $.templates($("script.list-tmpl", this.el)[0])
			};

			this.elPageContent = $(".list-view .list-view-content", this.el);
			this.elPager = $(".list-view .list-view-footer", this.el).zybpager(
					{
						pageselect : this.proxy("onPageSelect")
					});
			this.loadPage(1);

			this.el.on("click", ".list-view .icon-edit", this
							.proxy("onEditClick"));
			this.el.on("click", ".list-view .icon-remove", this
							.proxy("onRemoveClick"));
		},

		onAddClick : function(e) {
			e.preventDefault();
			e.stopPropagation();
			$(e.target).trigger("zyb-page-load",
					"/admin/productsandservices/testimonial/edit/0");
		},

		onEditClick : function(e) {
			e.preventDefault();
			e.stopPropagation();

			var id = $(e.target).closest(".testimonial-view")
					.data("testimonial");
			if (id) {
				$(e.target).trigger("zyb-page-load",
						"/admin/productsandservices/testimonial/edit/" + id);
			}
		},

		onRemoveClick : function(e) {
			e.preventDefault();
			e.stopPropagation();

			var id = $(e.target).closest(".testimonial-view")
					.data("testimonial");
			if (id) {
				$.ajax({
					url : ZtUtils.getContextPath()
							+ "/admin/productsandservices/testimonial/delete/"
							+ id
				}).success(this.proxy("onRemoveSuccess"));
			}
		},

		onRemoveSuccess : function(testimonial) {
			this.loadPage(this.currentPage);
		},

		loadPage : function(page) {
			if (this._loading_page_page) {
				return;
			}

			this.currentPage = page;
			$.ajax({
				url : ZtUtils.getContextPath()
						+ "/productsandservices/testimonial/page/" + page,
				data : {
					rows : 10
				}
			}).success(this.proxy("onPageSuccess")).always(this
					.proxy("onPageComplete"));
		},

		onPageSuccess : function(result) {
			this.currentPage = result.page;
			if (result.rowCount) {
				var rowCount = result.rows.length;
				if (rowCount == 0) {
					this.loadPage(result.pages);
				} else {
					this.elPageContent.html(this.tmpls.tmplList.render(
							result.rows, this.tmpls));
				}
			} else {
				this.elPageContent
						.html("There are no testimonials available now, please come back again.");
			}
			this.elPager.zybpager("update", result.pages, result.page);
		},
		onPageComplete : function() {
			this._loading_page = false;
		},

		onPageSelect : function(e, page) {
			this.loadPage(page);
		}
	});
});