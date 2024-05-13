<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="ISO-8859-1">
      <title>Sign Up</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
      <link href="./css/global.css" rel="stylesheet">
      <style>
        @import url('https://fonts.googleapis.com/css2?family=Oleo+Script+Swash+Caps:wght@400;700&display=swap');
      </style>
    </head>

    <body>
      <main class="container shadow p-3 mb-5 bg-body-tertiary rounded">
        <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
        <h1 class="title text-center">Alke Wallet</h1>
        <div class="separator">
          <form class="form" action="register" method="post">
            <div class="mb-3">
              <label for="name" class="form-label">Name</label>
              <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="mb-3">
              <label for="lastName" class="form-label">Last Name</label>
              <input type="text" class="form-control" id="lastName" name="lastName" required>
            </div>
            <div class="mb-3">
              <label for="email" class="form-label">Email address</label>
              <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" required>
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Password</label>
              <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="d-flex justify-content-between">
              <button type="submit" class="btn btn-primary">Sign Up</button>
              <a href="login.jsp">Log In</a>
            </div>
          </form>
          <img
            src="https://play-lh.googleusercontent.com/8vKc5TccVqIgyWhEpTFUYhTkY-5d9XpFzi1ZLKkxy5zSlBe8dKzuH3aJnG7NH8DFug=w526-h296-rw"
            alt="wallet">
        </div>
      </main>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

      <script type="text/javascript">
        var status = document.getElementById("status").value;
        console.log(status);
        if (status == "success") {
          swal.fire("Congratulations", "Account created", "success");
        } else if (status == "failed") {
          swal.fire("Error", "There is already a registered email", "error");
        }
      </script>
    </body>

    </html>