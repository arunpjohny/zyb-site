$(function() {

	$.Class("zyb.main.placements.Main", {}, {
		init : function(el, options) {
			this.el = $(el);
			this.options = $.extend({}, options);

			this.elOpeningCt = $(".zyb-placement-openings .opening-container",
					this.el);

			this.elNextOpening = $(".zyb-placement-openings .next", this.el);
			this.elPrevOpening = $(".zyb-placement-openings .prev", this.el);

			$.templates("placements-opening", $(
							"script.placement-opening-tmpl", this.el)[0]);

			this.el.on("click", ".zyb-placement-openings .dir-loader", this
							.proxy("onOpeningLoaderClick"));

			this.loadOpening(0);
		},

		onOpeningLoaderClick : function(e) {
			var $target = $(e.target);
			var id = $target.data("openingid");
			if (id) {
				this.loadOpening(id);
			}
		},

		loadOpening : function(id) {
			if (this._loading_opening) {
				return;
			}

			$.ajax({
				url : ZtUtils.getContextPath() + "/placements/opening/pview/"
						+ id
			}).success(this.proxy("onOpeningRequestSuccess")).always(this
					.proxy("onOpeningRequestComplete"));
		},

		onOpeningRequestSuccess : function(result) {
			if (result.opening) {
				this.elOpeningCt
						.html($.render["placements-opening"](result.opening));

				if (result.next) {
					this.elNextOpening.data("openingid", result.next);
					this.elNextOpening.show();
				} else {
					this.elNextOpening.data("openingid", 0);
					this.elNextOpening.hide();
				}
				if (result.prev) {
					this.elPrevOpening.data("openingid", result.prev);
					this.elPrevOpening.show();
				} else {
					this.elPrevOpening.data("openingid", 0);
					this.elPrevOpening.hide();
				}
			} else {
				this.elOpeningCt
						.html("There are no openings available now, please come back again.");
			}
		},

		onOpeningRequestComplete : function() {
			this._loading_opening = false;
		}
	});
});