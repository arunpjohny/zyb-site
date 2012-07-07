$(function() {

	$.Class("zyb.main.productsandservices.appsgallery.Main", {}, {
		init : function(el, options) {
			this.el = $(el);
			this.options = $.extend({}, options);

			this.btnAdd = $(".application-add", this.el).on("click",
					this.proxy("onAddClick"));

			this.tmpls = {
				tmplList : $.templates($("script.list-tmpl", this.el)[0]),
				tmplView : $.templates($("script.view-tmpl", this.el)[0])
			};

			this.elPageContent = $(".gallery-view .gallery-content", this.el);
			this.elPager = $(".gallery-view .gallery-footer", this.el)
					.zybpager({
								pageselect : this.proxy("onPageSelect")
							});
			this.loadPage(1);

			this.el.on("click", ".gallery-view .download", this
							.proxy("onGalleryDownloadClick"));
			this.el.on("click", ".gallery-view .icon-edit", this
							.proxy("onEditClick"));
			this.el.on("click", ".gallery-view .icon-remove", this
							.proxy("onRemoveClick"));
			$(window).on("click", ".modal-application-view .download",
					this.proxy("onDownloadApplicationClick"));
		},

		onAddClick : function(e) {
			e.preventDefault();
			e.stopPropagation();
			$(e.target).trigger("zyb-page-load",
					"/admin/productsandservices/app-gallery/edit/0");
		},

		onEditClick : function(e) {
			e.preventDefault();
			e.stopPropagation();

			var id = $(e.target).closest(".application-view")
					.data("application");
			if (id) {
				$(e.target).trigger("zyb-page-load",
						"/admin/productsandservices/app-gallery/edit/" + id);
			}
		},

		onRemoveClick : function(e) {
			e.preventDefault();
			e.stopPropagation();

			var id = $(e.target).closest(".application-view")
					.data("application");
			if (id) {
				$.ajax({
					url : ZtUtils.getContextPath()
							+ "/admin/productsandservices/app-gallery/delete/"
							+ id
				}).success(this.proxy("onRemoveSuccess"));
			}
		},

		onRemoveSuccess : function(application) {
			this.loadPage(this.currentPage);
		},

		loadPage : function(page) {
			if (this._loading_page_page) {
				return;
			}

			this.currentPage = page;
			$.ajax({
				url : ZtUtils.getContextPath()
						+ "/productsandservices/app-gallery/page/" + page,
				data : {
					rows : 20
				}
			}).success(this.proxy("onPageSuccess")).always(this
					.proxy("onPageComplete"));
		},

		onPageSuccess : function(result) {
			this.currentPage = result.page;
			if (result.rowCount) {
				var contents = [];
				var rowCount = result.rows.length;
				if (rowCount == 0) {
					this.loadPage(result.pages);
				} else {
					var _self = this;
					$.each(result.rows, function(i, v) {
								if (i % 2 == 0) {
									contents.push("<div class='row-fluid'>");
								}
								contents.push(_self.tmpls.tmplList.render(v,
										_self.tmpls));
								if (i % 2 == 1 || i == rowCount - 1) {
									contents.push("</div>");
								}
							});
					this.elPageContent.html(contents.join(""));
				}
			} else {
				this.elPageContent
						.html("There are no applications available now, please come back again.");
			}
			this.elPager.zybpager("update", result.pages, result.page);
		},
		onPageComplete : function() {
			this._loading_page = false;
		},

		onPageSelect : function(e, page) {
			this.loadPage(page);
		},

		onGalleryDownloadClick : function(e) {
			e.preventDefault();
			e.stopPropagation();

			var id = $(e.target).closest(".application-view")
					.data("application");
			if (id) {
				$.ajax({
					url : ZtUtils.getContextPath()
							+ "/productsandservices/app-gallery/" + id
				}).success(this.proxy("onGalleryDownloadClickSuccess"));
			}
		},

		onGalleryDownloadClickSuccess : function(application) {
			var el = $(this.tmpls.tmplView.render(application, this.tmpls))
					.appendTo(document);
			el.modal({
						hidden : function() {
							el.remove();
						}
					});
		},

		onDownloadApplicationClick : function(e) {
			e.preventDefault();
			e.stopPropagation();

			var id = $(e.target).closest(".modal-application-view")
					.data("application");
			if (id) {
				window.location = ZtUtils.getContextPath()
						+ "/productsandservices/app-gallery/application/" + id;
			}
		}
	});
});