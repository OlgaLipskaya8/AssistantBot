<%@ include file="/webresources/header.jspf"%>
    <h1>Create city</h1>
    <div class="panel-body">
        <div class="row">
            <div class="col-lg-12">
                <form role="form" action="${contextPath}/city/create" method="POST">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input class="form-control" type="name" name="name" path="name" autocomplete="off" />
                    </div>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check fa-fw"></i>Save</button>
                    <a href="${pageContext.request.contextPath}/city" class="btn btn-danger"><i class="fa fa-times fa-fw"></i>Cancel</a>
                </form>
            </div>
        </div>
    </div>
<%@ include file="/webresources/footer.jspf"%>
l