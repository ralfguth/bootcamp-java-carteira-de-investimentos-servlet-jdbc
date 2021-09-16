<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Transações</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container">

	<h1 class="text-center">Cadastro de Transações</h1>
	<form action="<c:url value="/transacoes"/>" method="POST">
		<div class="form-group">
			<label for="ticker">Ticker</label>
			<input id="ticker" class="form-control" name="ticker">
		</div>
		<div class="form-group">
			<label for="data">Data</label>
			<input id="data" class="form-control" name="data" type="date">
		</div>
		<div class="form-group">
			<label for="preco">Preço (R$)</label>
			<input id="preco" class="form-control" type="number" step="any" min="1" name="preco" />
		</div>
		<div class="form-group">
			<label for="quantidade">Quantidade</label>
			<input id="quantidade" class="form-control" name="quantidade" type="number">
		</div>
		<div class="form-group">
			<label for="tipo">Tipo</label>
			<select id="tipo" class="form-select" name="tipo">
				<option>Compra</option>
				<option>Venda</option>
			</select>
		</div>
		<div class="form-group">
			<input type="submit" value="Salvar" class="mt-2 btn btn-primary">
		</div>
	</form>

	<h1 class="text-center">Lista de Transações</h1>
	<table class="table table-hover table-bordered table-striped">
		<thead>
			<tr>
				<th>TICKER</th>
				<th>DATA</th>
				<th>PREÇO</th>
				<th>QUANTIDADE</th>
				<th>TIPO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transacoes}" var="t">
				<tr>
					<td>${t.ticker}</td>
					<td>${t.data}</td>
					<td>${t.preco}</td>
					<td>${t.quantidade}</td>
					<td>${t.tipo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>