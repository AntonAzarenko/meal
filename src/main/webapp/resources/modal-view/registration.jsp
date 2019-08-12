<div class="modal fade" id="register">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Registration</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="registration" method="post">
                    <div class="form-group">
                        <input type="text" placeholder="Enter name" class="form-control" id="name" name="name">
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Enter email" class="form-control" id="login" name="login">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Enter password" class="form-control" id="password" name="password">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" onclick="addUser()" class="btn btn-primary">Registration</button>
            </div>
        </div>
    </div>
</div>
