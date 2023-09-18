const { Given, When, Then } = require("@cucumber/cucumber");
const { SpreeAccountPom } = require("../../pom/SpreeAccountPom");


Given("User has launched Chrome browser", async function () {
});
When("User navigates to Spree login page", async function () {
    await this.openUrl('http://demo.spreecommerce.org/login');
})

When("User enters valid username and password in Spree login page", async function () {
    await this.page.locator("*[name='spree_user[email]']").fill("c@s.com")
    await this.page.locator("*[name='spree_user[password]']").fill("123456")
})
When("User clicks login on Spree login page", async function () {
    await this.page.locator("*[name='commit']").click()
    this.spreeaccount = new SpreeAccountPom(this.page)
    await this.page.waitForTimeout(2000)
    await this.spreeaccount.finishsetup()
})

/*When("User deletes all existing addresses on Spree account page", {timeout: 60000}, async function () {
    while (    await this.spreeaccount.hasAtLeastOneDeleteBtn()   ) {
        await deletefirstaddr(this.spreeaccount);
    }
})
When("User deletes first address on Spree account page", deletefirstaddr)

async function deletefirstaddr(spreeaccount) {
    await spreeaccount.deleteFirstAddress();
}
Then("My Account page should display", async function () {
    await this.spreeaccount.verifyHeader()
})*/