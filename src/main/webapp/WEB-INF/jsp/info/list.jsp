<%@ include file="/webresources/header.jspf"%>
    <h1>Info list</h1>
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>Text</th>
                <th>City</th>
                <th width="140"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var = "info" items="${infoList}">
                <tr>
                    <td>${info.text}</td>
                    <td>${info.city.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/info/${info.id}" class="btn btn-primary btn-sm"><i class="fa fa-info-circle fa-fw"></i></a>
                        <a href="${pageContext.request.contextPath}/info/update/${info.id}" class="btn btn-warning btn-sm"><i class="fa fa-pencil-square fa-fw"></i></a>
                        <a data-toggle="modal" data-target="#confirm_delete_${info.id}" href="#" class="btn btn-danger btn-sm"><i class="fa fa-trash fa-fw"></i></a>
                        <div class="modal fade" id="confirm_delete_${info.id}" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">Confirmation</h4>
                                    </div>
                                    <div class="modal-body">
                                        <p>Are you sure to delete info?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <form action="${pageContext.request.contextPath}/info/remove/${info.id}" method="DELETE">
                                            <a href="#" class="btn" data-dismiss="modal">Cancel</a><button type="submit" class="btn btn-primary">Confirm</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/info/create" class="btn btn-success"><i class="fa fa-plus fa-fw"></i>Add</a>
<%@ include file="/webresources/footer.jspf"%>
