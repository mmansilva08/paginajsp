<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculadora</title>
</head>
<body>
    <h1>Calculadora</h1>
    <form action="calculo" method="post">
        <label for="valor1">Primeiro valor:</label>
        <input type="text" id="valor1" name="valor1" value="${param.valor1}">
        <span style="color: red;">${erroValor1}</span><br>

        <label for="valor2">Segundo valor:</label>
        <input type="text" id="valor2" name="valor2" value="${param.valor2}">
        <span style="color: red;">${erroValor2}</span><br>

        <label for="operacao">Operacao:</label>
        <select id="operacao" name="operacao">
            <option value="+" ${param.operacao == '+' ? 'selected' : ''}>+ Adicao</option>
            <option value="-" ${param.operacao == '-' ? 'selected' : ''}>- Subtracao</option>
            <option value="*" ${param.operacao == '*' ? 'selected' : ''}>* Multiplicacao</option>
            <option value="/" ${param.operacao == '/' ? 'selected' : ''}>/ Divisao</option>
        </select>
        <span style="color: red;">${erroOperacao}</span><br>

        <p>
            <button type="submit">Calcular</button>
        </p>
    </form>

    <h2>Resultado</h2>
    <p>${resultado}</p>
</body>
</html>
