document.querySelector("[data-trigger-click]").addEventListener("click", function() {
	const relatedLink = document.querySelector("[data-relatedlink='re_link']");
	if (relatedLink) {
	relatedLink.click();  // 강제 클릭 실행
	}
});
document.querySelectorAll("[data-trigger-click]").forEach((element) => {
    element.addEventListener("click", () => {
        const link = element.querySelector("[data-relatedlink]");
        if (link) {
            window.location.href = link.href; // a 태그의 링크로 이동
        }
    });
});
