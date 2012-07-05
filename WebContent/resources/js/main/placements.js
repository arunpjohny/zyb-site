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
			this.tmpls = {
				placementOpening : $.templates($(
						"script.placement-opening-tmpl", this.el)[0]),
				viwPlacementOpening : $.templates($(
						"script.placement-opening-view-tmpl", this.el)[0]),
				edtPlacementOpening : $.templates($(
						"script.placement-opening-edit-tmpl", this.el)[0])
			};

			this.el.on("click", ".list-view-item > header", this
							.proxy("onItemHeaderClick"));

			this.elOpeningPager = $(
					".zyb-placement-openings .list-view .list-view-footer",
					this.el).zybpager({
						pageselect : this.proxy("onOpeningPageSelect")
					});

			$(".zyb-placement-openings", this.el).on("click",
					".placement-opening-edit .save",
					this.proxy("onOpeningSaveClick"));
			$(".zyb-placement-openings", this.el).on("click",
					".placement-opening-edit .cancel",
					this.proxy("onOpeningCancelClick"));
			$(".zyb-placement-openings", this.el).on("click",
					".placement-opening-view .icon-edit",
					this.proxy("onOpeningEditClick"));
			$(".zyb-placement-openings", this.el).on("click",
					".placement-opening-view .icon-remove",
					this.proxy("onOpeningRemoveClick"));

			this.btnAddOpening = $(".zyb-placement-openings .opening-add",
					this.el).on("click", this.proxy("onOpeningAddClick"));

			$(".zyb-placement-openings .add-form-container", this.el).on(
					"click", ".save", this.proxy("onOpeningAddSaveClick"));
			$(".zyb-placement-openings .add-form-container", this.el).on(
					"click", ".cancel", this.proxy("onOpeningAddCancelClick"));

			this.loadOpeningPage(1);
			
			this.elApplyModalForm = $(".modal-apply-opening", this.el).modal({
						show : false
					});
			this.elApplyModalForm.validate({
						rules : {
							name : {
								required : true
							},
							mobile : {
								required : true,
								digits : true,
								minlength : 10
							},
							email : {
								required : true,
								email : true
							},
							body : {
								required : true
							},
							file : {
								accept : "doc|docx|pdf|txt"
							}
						}
					});
			$(".opening-apply", this.elApplyModalForm).on("click",
					this.proxy("onOpeningApplySubmitClick"));
			$(".zyb-placement-openings", this.el).on("click", ".opening-apply",
					this.proxy("onOpeningApplyClick"));
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

			this.currentOpeningPage = page;
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
			this.currentOpeningPage = result.page;
			if (result.rowCount) {
				this.elOpeningCt.html(this.tmpls.placementOpening.render(
						result.rows, this.tmpls));
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
		},

		onOpeningSaveClick : function(e) {
			e.preventDefault();
			e.stopPropagation();

			var target = $(e.target);
			var form = target.closest("form");
			var id = target.closest(".list-view-item").data("opening");

			if (!form.valid()) {
				return;
			}

			$.ajax({
				type : "POST",
				url : ZtUtils.getContextPath()
						+ "/admin/placements/opening/edit/" + id,
				data : form.serialize()
			}).success(this.proxy("onOpeningSaveSuccess"));
		},

		onOpeningSaveSuccess : function(result) {
			if (result.id) {
				var item = $(
						".zyb-placement-openings .list-view-item[data-opening='"
								+ result.id + "']", this.el);
				$(".placement-opening-view", item)
						.html(this.tmpls.viwPlacementOpening.render(result,
								this.tmpls)).show();
				$(".placement-opening-edit", item).hide();
			}
		},

		onOpeningCancelClick : function(e) {
			e.preventDefault();
			e.stopPropagation();

			var target = $(e.target);
			target.closest(".placement-opening-edit").hide().prev().show();
		},

		onOpeningEditClick : function(e) {
			var target = $(e.target);
			target.closest(".placement-opening-view").hide().next().show()
					.find("form input:eq(0)").focus();

			var form = $("form", target.closest(".placement-opening-view")
							.next());
			this.setOpeningValidator(form);
		},

		onOpeningRemoveClick : function(e) {
			var target = $(e.target);
			var id = target.closest(".list-view-item").data("opening");

			$.ajax({
				url : ZtUtils.getContextPath()
						+ "/admin/placements/opening/delete/" + id
			}).success(this.proxy("onOpeningDeleteSuccess"));
		},

		onOpeningDeleteSuccess : function(result) {
			this.loadOpeningPage(this.currentOpeningPage);
		},

		onOpeningAddClick : function() {
			if (!this.addOpeningContainer) {
				this.addOpeningContainer = $(
						".zyb-placement-openings .add-form-container", this.el);
				this.addOpeningContainer.html(this.tmpls.edtPlacementOpening
						.render({
									id : 0
								}, this.tmpls));
				this.addOpeningForm = $("form", this.addOpeningContainer);
				this.setOpeningValidator(this.addOpeningForm);
			} else {
				this.addOpeningForm.resetForm();
			}
			this.btnAddOpening.attr("disabled", "disabled");
			this.addOpeningContainer.show();
		},

		onOpeningAddSaveClick : function(e) {
			e.preventDefault();
			e.stopPropagation();

			var target = $(e.target);
			var form = target.closest("form");

			if (!form.valid()) {
				return;
			}

			$.ajax({
				type : "POST",
				url : ZtUtils.getContextPath()
						+ "/admin/placements/opening/edit/0",
				data : form.serialize(),
				validator : {
					form : form
				}
			}).success(this.proxy("onOpeningAddSuccess"));
		},

		onOpeningAddSuccess : function(e) {
			this.loadOpeningPage(1);
			this.btnAddOpening.removeAttr("disabled");
			this.addOpeningContainer.hide();
			this.addOpeningForm.resetForm();
		},

		onOpeningAddCancelClick : function(e) {
			e.preventDefault();
			e.stopPropagation();

			this.btnAddOpening.removeAttr("disabled");
			this.addOpeningContainer.hide();
			this.addOpeningForm.resetForm();
		},

		setOpeningValidator : function(form) {
			if (!form.data("validator")) {
				form.validate({
							rules : {
								company : {
									required : true
								},
								position : {
									required : true
								},
								noOfOpenings : {
									required : true,
									digits : true
								},
								contactPerson : {
									required : true
								},
								contactEmail : {
									email : true
								},
								jobDescription : {
									required : true
								},
								desiredProfile : {
									required : true
								}
							}
						});
			}
		},

		onOpeningApplyClick : function(e) {
			var target = $(e.target);
			var id = target.closest(".list-view-item").data("opening");
			if (id) {
				this.elApplyModalForm.attr(
						"action",
						ZtUtils.getContextPath() + "/placements/opening/apply/"
								+ id).clearForm().modal('show');
			}
		},

		onOpeningApplySubmitClick : function(e) {
			e.preventDefault();
			e.stopPropagation();
			if (this.elApplyModalForm.valid()) {
				this.elApplyModalForm.ajaxSubmit({
							success : this.proxy("openingApplySubmitSuccess"),
							error : this.proxy("openingApplySubmitError")
						});
			}
		},

		openingApplySubmitSuccess : function(result) {
			this.elApplyModalForm.modal('hide');
			if (result.opening) {
				$(
						".zyb-placement-openings .list-view-item[data-opening='"
								+ result.opening.id + "'] .opening-apply",
						this.el).attr("disabled", "disabled");
			}
		},
		
		openingApplySubmitError: function(result) {
			this.elApplyModalForm.modal('hide');
		}
	});
});