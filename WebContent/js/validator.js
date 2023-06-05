let btn = document.querySelector("#btn");
let last_name = document.querySelector("#last_name");
let first_name = document.querySelector("#first_name");
let male = document.querySelector("#male");
let female = document.querySelector("#female");
let phone_number = document.querySelector("#phone_number");
let mail_address = document.querySelector("#mail_address");

btn.addEventListener("click", () => {
	
	if(last_name.value.trim() === "" || first_name.value.trim() === "") {
		alert("名前を入力してください。");
		return;
	}
	
	if(!(male.checked || female.checked)) {
		alert("性別を選択してください。")
		return;
	}
	if(!isFinite(phone_number.value) || phone_number.value.trim() === "") {
		alert("電話番号の入力が不正です。")
		return;
	}
	if(!mail_address.value.includes("@")) {
		alert("メールアドレスの入力が不正です。");
		return;
	}
	
	document.myform.submit();
});

