$(function() {

	$.Class("zyb.main.placements.Main", {}, {
		init : function(el, options) {
			this.el = $(el);
			this.options = $.extend({}, options);

			this.elOpeningCt = $(
					".zyb-placement-openings .list-view .list-view-content",
					this.el);

			$.templates("placements-opening", $(
							"script.placement-opening-tmpl", this.el)[0]);

			this.el.on("click", ".list-view-item > header", this
							.proxy("onItemHeaderClick"));

			this.elOpeningPager = $(
					".zyb-placement-openings .list-view .list-view-footer",
					this.el).zybpager({
						pageselect : this.proxy("onOpeningPageSelect")
					});

			this.loadOpeningPage(1);
		},

		onAddClick : function(e) {

		},

		onItemHeaderClick : function(e) {
			var target = $(e.target);
			var elItem = target.closest(".list-view-item");
			var view = elItem.children(".list-view-item-body");
			if (view.is(":visible")) {
				view.hide();
			} else {
				view.show();
			}
		},

		loadOpeningPage : function(page) {
			if (this._loading_opening_page) {
				return;
			}

			$.ajax({
				url : ZtUtils.getContextPath() + "/placements/opening/page/"
						+ page,
				data : {
					rows : 10
				}
			}).success(this.proxy("onOpeningPageSuccess")).always(this
					.proxy("onOpeningPageComplete"));
		},

		onOpeningPageSuccess : function(result) {
			var rows = [];
			var tmpl = $.render["placements-opening"];
			$.each(result.rows, function(i, v) {
						rows.push(tmpl(v));
					});
			if (result.rowCount) {
				this.elOpeningCt.html(rows.join(""));
			} else {
				this.elOpeningCt
						.html("There are no openings available now, please come back again.");
			}
			this.elOpeningPager.zybpager("update", result.pages, result.page);
		},
		onOpeningPageComplete : function() {
			this._loading_opening = false;
		},

		onOpeningPageSelect : function(e, page) {
			this.loadOpeningPage(page);
		}

	});
});