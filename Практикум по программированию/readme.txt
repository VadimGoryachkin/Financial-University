
<meta charset="utf-8">
<script> 
var otv = 0;
const a1 = 3;
const a2 = 8;
alert("Начало")
alert("отгадки " + otv);
alert("сколько сторон у треугольника?")
var a = parseInt(prompt());
if (a==a1) {
	alert("Верно");
	otv++
} else {
	alert("неверно");
}
alert("сколько лап у павука?")
var b = parseInt(prompt());
if (b==a2) {
	alert("Верно");
	otv++
} else {
	alert("неверно");
}
alert("Ваши отгадки - " + otv);
alert("конец")
</script>
