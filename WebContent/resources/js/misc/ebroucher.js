$(function() {

	$.Class("zyb.misc.broucher.Main", {}, {
		init : function(el, options) {
			this.el = $(el);
			this.options = $.extend({}, options);

			$(".ebroucher-add", this.el).on("click", this.proxy("onAddClick"));

			this.el.on("click", ".zyb-broucher .icon-edit", this
							.proxy("onEditClick"));

			this.el.on("click", ".zyb-broucher .icon-remove", this
							.proxy("onRemoveClick"));
		},

		onAddClick : function(e) {
			$(e.target).trigger("zyb-page-load", "/admin/ebroucher/edit/0");
		},

		onEditClick : function(e) {
			e.preventDefault();
			e.stopPropagation();
			var $target = $(e.target);
			var id = $target.closest(".zyb-broucher").data("broucher");
			if (id) {
				$target.trigger("zyb-page-load", "/admin/ebroucher/edit/" + id);
			}
		},

		onRemoveClick : function(e) {
			e.preventDefault();
			e.stopPropagation();
			var $target = $(e.target);
			var id = $target.closest(".zyb-broucher").data("broucher");
			if (id) {
				$.ajax({
					url : ZtUtils.getContextPath() + "/admin/ebroucher/delete/"
							+ id
				}).done(this.proxy("onRemoveSuccess"));
			}
		},

		onRemoveSuccess : function(result) {
			if (result && result.id) {
				$(".zyb-broucher[data-broucher='" + result.id + "']", this.el)
						.remove();
			}
		}
	});
});