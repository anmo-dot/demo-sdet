const { expect, Locator, Page } = require('@playwright/test');
exports.SpreeAccountPom = class SpreeAccountPom {

    constructor(page) {
        this.page = page
        
        this.header = page.locator("//h3[text()='My Account']")
        
        this.accounticon = page.locator("//*[@id='account-button']")
        //can't find logout?
    
        this.deleteconfirmbtn = page.locator("//*[@id='delete-address-popup-confirm']")
        
        this.addaddrlink = page.locator("//a[text()='Add new address'");        
    }
    async finishsetup() {
        this.addrlabels = await this.page.locator("//address/h4").all()
        this.addrnames = await this.page.locator("//address/span").all()
        this.addraddrs = await this.page.locator("//address/div[1]").all()
        this.addrareas = await this.page.locator("//address/div[2]").all()
        this.addrcountries = await this.page.locator("//address/div[3]").all()
        
        this.deleteaddrbtns = await this.page.locator("//a[contains(@class, 'js-delete-address-link')]").all()
    
        this.editaddrbtns = await this.page.locator("a[data-hook='edit_address']").all()
    }

    
    async verifyHeader() {expect(this.header).toBeVisible()}

    
    async logout() {
        await this.accounticon.click();
//	    driver.findElement(By.linkText("LOGOUT")).click();
//	    driver.findElement(By.xpath("//a[text()='LOGOUT']")).click();
//	    driver.findElement(By.xpath("//*[@id='link-to-account']/a[2]")).click();
        await this.page.goto("http://demo.spreecommerce.org/logout");
    }
    
    async hasAtLeastOneDeleteBtn() {
        return this.deleteaddrbtns.length > 0;
    }
    async deleteFirstAddress() {
        console.log("pom delete first address")
        console.log(this.deleteaddrbtns)
        await this.deleteaddrbtns[0].click();
        await this.deleteconfirmbtn.click();
        await this.page.waitForTimeout(3000);
        await this.finishsetup()
    }
    async clickAddAddrLink() {
        await this.addaddrlink.click();
    }
    async editFirstAddress() {
        await this.editaddrbtns[0].click();
    }
	

    async getTrimmedText(ele) { return (await ele.innerText()).trim(); }
    
    async verifyAddressExists(
            label, name, address, ctstzp, country 
        ) {
        await this.page.waitForTimeout(1000);
        for (let i = 0; i < this.addrnames.length; i++)
            if  (
                (label!="" && getTrimmedText(this.addrlabels.get(i)) == (label))
                && getTrimmedText(this.addrnames.get(i)) == (name)
                && getTrimmedText(this.addraddrs.get(i)) == (address)
                && getTrimmedText(this.addrareas.get(i)) == (ctstzp)
                && getTrimmedText(this.addrcountries.get(i)) == (country)
                )
                return;
        expect(null).toBeTruthy();
    }

}

