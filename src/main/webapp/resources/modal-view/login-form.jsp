<div class="modal fade" id="log_in">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">LogIn</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" id="enterForm" action="spring_security_check" method="post">

                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Enter email"  name='username'>
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Enter password"  class="form-control"  name='password'>
                    </div>
                    <div class="modal-footer">
                        <button type="submit"  class="btn btn-success">Log in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
