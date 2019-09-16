<%@ include file="/webresources/header.jspf"%>
    <div class="panel-heading">
        <h1>Update info</h1>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-lg-12">
                <form role="form" action="${contextPath}/info/update" method="POST">
                    <div class="form-group">
                        <label for="id">Id</label>
                        <input class="form-control" type="number" name="id" readonly value="${info.id}" autocomplete="off" />
                    </div>
                    <div class="form-group">
                        <label for="number">Text</label>
                        <input class="form-control" type="text" name="text" value="${info.text}" autocomplete="off" />
                    </div>
                    <div class="form-group">
                        <label for="city">City</label>
                        <select path="city" name="city" class="form-control" id="account">
                            <c:forEach var = "city" items="${cityList}">
                                <c:if test="${city.id != info.city.id}">
                                    <option value="${city.id}">${city.name}</option>
                                </c:if>
                                <c:if test="${city.id == info.city.id}">
                                    <option value="${city.id}" selected>${city.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check fa-fw"></i>Save</button>
                    <a href="${pageContext.request.contextPath}/info" class="btn btn-danger"><i class="fa fa-times fa-fw"></i>Cancel</a>
                </form>
            </div>
        </div>
    </div>
<%@ include file="/webresources/footer.jspf"%>
