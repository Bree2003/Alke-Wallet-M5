<% if(session.getAttribute("id")==null) { response.sendRedirect("login.jsp"); } %>
    <%@page import="model.User" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="ISO-8859-1" />
                    <title>Home</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                        crossorigin="anonymous" />
                    <link href="./css/global.css" rel="stylesheet" />
                    <style>
                        @import url("https://fonts.googleapis.com/css2?family=Oleo+Script+Swash+Caps:wght@400;700&display=swap");
                    </style>
                </head>

                <body>
                    <main class="container shadow p-3 mb-5 bg-body-tertiary rounded">
                        <% User user=(User) session.getAttribute("user");%>
                            <input type="hidden" id="status" value="<%= session.getAttribute("status") %>">
                            <div>
                                <h1 class="title text-center">Hello, <c:out value="${user.getName()}"></c:out>
                                </h1>
                                <h3 class="text-center mb-5">Current Balance, $<c:out value="${user.getBalance()}">
                                    </c:out>
                                </h3>
                            </div>
                            <div class="d-flex justify-content-evenly mt-5">
                                <%-- Button trigger modal --%>
                                    <button type="button" class="buton btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#exampleModal">
                                        Deposit
                                    </button>
                                    <button type="button" class="buton btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#exampleModal2">
                                        Withdraw
                                    </button>
                            </div>
                            <button class="btn btn-outline-dark"><a href="logout">Log Out</a></button>
                            <%-- Modal --%>
                                <div class="modal fade" id="exampleModal" tabindex="-1"
                                    aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered">
                                        <div class="modal-content">
                                            <form action="" method="post">
                                                <div class="modal-header">
                                                    <h1 class="modal-title fs-5" id="exampleModalLabel">
                                                        Deposit Operation
                                                    </h1>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="mb-3">
                                                        <input type="hidden" name="operation" value="deposit">
                                                        <label for="amount" class="form-label">Amount</label>
                                                        <input type="number" class="form-control" id="amount"
                                                            name="amount" step="0.01" required />
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">
                                                        Close
                                                    </button>
                                                    <button type="submit" class="btn btn-primary">
                                                        Done
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal fade" id="exampleModal2" tabindex="-1"
                                    aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered">
                                        <div class="modal-content">
                                            <form action="" method="post">
                                                <div class="modal-header">
                                                    <h1 class="modal-title fs-5" id="exampleModalLabel">
                                                        Deposit Operation
                                                    </h1>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="mb-3">
                                                        <input type="hidden" name="operation" value="withdraw">
                                                        <label for="amount" class="form-label">Amount</label>
                                                        <input type="number" class="form-control" id="amount"
                                                            name="amount" step="0.01" required />
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">
                                                        Close
                                                    </button>
                                                    <button type="submit" class="btn btn-primary">
                                                        Done
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                    </main>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                        crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
                    <script type="text/javascript">
                        var status = document.getElementById("status").value;
                        if (status == "success") {
                            swal.fire("Congratulations", "Successful operation", "success");
                        } else if (status == "failed") {
                            swal.fire("Error", "Failed operation", "error");
                        }
                    </script>
                </body>

                </html>