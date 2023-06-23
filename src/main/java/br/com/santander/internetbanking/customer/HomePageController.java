package br.com.santander.internetbanking.customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @GetMapping(value = "/")
    public String getHomePage() {
        String html = "<h1> REST API project Internet Banking </h1>\n" +
                "<span>Spring boot REST API project template using jpa (Springboot REST API whch connects H2 database).</span>\n" +
                "\n" +
                "<h2>Project description </h2>\n" +
                "<p>Java backend test for Banco Santander, APIs were implemented with the following functionalities: Register a client, Retrieve all registered clients, Withdraw an amount that subtracts from the client's balance considering an administration fee, Deposit an amount that increases the balance of a specific client, and Query transaction history by date.</p>\n" +
                "\n" +
                "<h2>Setup</h2>\n" +
                "<ul dir=\"auto\">\n" +
                "  <li>Clone and open in Intellij Idea IDE</li>\n" +
                "  <li>Change database connection config in <code>src/main/resources/application.properties</code></li>\n" +
                "  <li>Install maven dependencies using IDE auto import or using the command <code>mvn install</code></li>\n" +
                "  <li>Run the app using <code>mvn spring-boot:run</code></li>\n" +
                "  <li>Browse <code>http//localhost:8080/</code></li>\n" +
                "</ul>\n" +
                "\n" +
                "<h2>Swagger APIs</h2>\n" +
                "<li>Documention <code>http://localhost:8080/santander-documentation/</code></li>\n" +
                "<li>API docs <code>http://localhost:8080/santander-api-docs</code></li>\n" +
                "\n" +
                "<h2>API Doc & Sample</h2>\n" +
                "\n" +
                "<ul dir=\"auto\">\n" +
                "<li>\n" +
                " <p dir=\"auto\">List all customers</p>\n" +
                "<div class=\"snippet-clipboard-content notranslate position-relative overflow-auto\"><pre class=\"notranslate\">\n" +
                " <code>GET /api/v1/customers\n" +
                "</code></pre><div class=\"zeroclipboard-container position-absolute right-0 top-0\">\n" +
                "    <clipboard-copy aria-label=\"Copy\" class=\"ClipboardButton btn js-clipboard-copy m-2 p-0 tooltipped-no-delay\" data-copy-feedback=\"Copied!\" data-tooltip-direction=\"w\" value=\"POST /api/v1/customers\" tabindex=\"0\" role=\"button\" style=\"display: inherit;\">\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-copy js-clipboard-copy-icon m-2\">\n" +
                "    <path d=\"M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z\"></path><path d=\"M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z\"></path>\n" +
                "</svg>\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-check js-clipboard-check-icon color-fg-success d-none m-2\">\n" +
                "    <path d=\"M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z\"></path>\n" +
                "</svg>\n" +
                "    </clipboard-copy>\n" +
                "  </div></div>\n" +
                "</li>\n" +
                "\n" +
                "<li>\n" +
                " <p dir=\"auto\">Create customer</p>\n" +
                "<div class=\"snippet-clipboard-content notranslate position-relative overflow-auto\"><pre class=\"notranslate\"><code>POST  /api/v1/customer\n" +
                "</code></pre><div class=\"zeroclipboard-container position-absolute right-0 top-0\">\n" +
                "    <clipboard-copy aria-label=\"Copy\" class=\"ClipboardButton btn js-clipboard-copy m-2 p-0 tooltipped-no-delay\" data-copy-feedback=\"Copied!\" data-tooltip-direction=\"w\" value=\"POST  /api/v1/customer\" tabindex=\"0\" role=\"button\" style=\"display: inherit;\">\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-copy js-clipboard-copy-icon m-2\">\n" +
                "    <path d=\"M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z\"></path><path d=\"M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z\"></path>\n" +
                "</svg>\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-check js-clipboard-check-icon color-fg-success d-none m-2\">\n" +
                "    <path d=\"M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z\"></path>\n" +
                "</svg>\n" +
                "    </clipboard-copy>\n" +
                "  </div></div>\n" +
                "<p dir=\"auto\">Body:</p>\n" +
                "<div class=\"snippet-clipboard-content notranslate position-relative overflow-auto\"><pre class=\"notranslate\"><code>{\n" +
                "   \"name\" : \"Anderson Camacho\",\n" +
                "  \t\"exclusivePlan\" : false,\n" +
                "  \t\"balance\" : 200,\n" +
                "  \t\"accountNumber\" : \"140458548\",\n" +
                "  \t\"dateOfBirth\" : \"13/02/1987\"\n" +
                "}\n" +
                "</code></pre><div class=\"zeroclipboard-container position-absolute right-0 top-0\">\n" +
                "    <clipboard-copy aria-label=\"Copy\" class=\"ClipboardButton btn js-clipboard-copy m-2 p-0 tooltipped-no-delay\" data-copy-feedback=\"Copied!\" data-tooltip-direction=\"w\" value=\"{\n" +
                "    &quot;name&quot;: &quot;Mark Price&quot;,\n" +
                "    &quot;email&quot;: &quot;mark@devslopes.com&quot;,\n" +
                "    &quot;mobile&quot;: &quot;0123456789&quot;\n" +
                "}\" tabindex=\"0\" role=\"button\" style=\"display: none;\">\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-copy js-clipboard-copy-icon m-2\">\n" +
                "    <path d=\"M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z\"></path><path d=\"M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z\"></path>\n" +
                "</svg>\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-check js-clipboard-check-icon color-fg-success d-none m-2\">\n" +
                "    <path d=\"M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z\"></path>\n" +
                "</svg>\n" +
                "    </clipboard-copy>\n" +
                "  </div></div>\n" +
                "<p dir=\"auto\">Content-Type:</p>\n" +
                "<div class=\"snippet-clipboard-content notranslate position-relative overflow-auto\"><pre class=\"notranslate\"><code>application/json\n" +
                "</code></pre><div class=\"zeroclipboard-container position-absolute right-0 top-0\">\n" +
                "    <clipboard-copy aria-label=\"Copy\" class=\"ClipboardButton btn js-clipboard-copy m-2 p-0 tooltipped-no-delay\" data-copy-feedback=\"Copied!\" data-tooltip-direction=\"w\" value=\"application/json\" tabindex=\"0\" role=\"button\">\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-copy js-clipboard-copy-icon m-2\">\n" +
                "    <path d=\"M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z\"></path><path d=\"M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z\"></path>\n" +
                "</svg>\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-check js-clipboard-check-icon color-fg-success d-none m-2\">\n" +
                "    <path d=\"M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z\"></path>\n" +
                "</svg>\n" +
                "    </clipboard-copy>\n" +
                "  </div></div>\n" +
                "</li>\n" +
                "\n" +
                " \n" +
                "  <li>\n" +
                "    <i>Note: Below is an example of URLs already filled in with the attributes to facilitate testing.</i><br />\n" +
                "  </li>\n" +
                "\n" +
                "<li>\n" +
                "<p dir=\"auto\">Withdraw</p>\n" +
                "<div class=\"snippet-clipboard-content notranslate position-relative overflow-auto\"><pre class=\"notranslate\">\n" +
                " <code>POST /api/v1/transactions/withdraw/{id}?valor={value}\n" +
                "</code></pre><div class=\"zeroclipboard-container position-absolute right-0 top-0\">\n" +
                "    <clipboard-copy aria-label=\"Copy\" class=\"ClipboardButton btn js-clipboard-copy m-2 p-0 tooltipped-no-delay\" data-copy-feedback=\"Copied!\" data-tooltip-direction=\"w\" value=POST /api/v1/transactions/withdraw/{id}?valor={value}\" tabindex=\"0\" role=\"button\" style=\"display: inherit;\">\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-copy js-clipboard-copy-icon m-2\">\n" +
                "    <path d=\"M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z\"></path><path d=\"M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z\"></path>\n" +
                "</svg>\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-check js-clipboard-check-icon color-fg-success d-none m-2\">\n" +
                "    <path d=\"M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z\"></path>\n" +
                "</svg>\n" +
                "    </clipboard-copy>\n" +
                "  </div></div>\n" +
                "</li>\n" +
                "\n" +
                "  <li>\n" +
                "<p dir=\"auto\">Deposit</p>\n" +
                "<div class=\"snippet-clipboard-content notranslate position-relative overflow-auto\"><pre class=\"notranslate\">\n" +
                " <code>POST /api/v1/transactions/deposit/{id}?valor={value}\n" +
                "</code></pre><div class=\"zeroclipboard-container position-absolute right-0 top-0\">\n" +
                "    <clipboard-copy aria-label=\"Copy\" class=\"ClipboardButton btn js-clipboard-copy m-2 p-0 tooltipped-no-delay\" data-copy-feedback=\"Copied!\" data-tooltip-direction=\"w\" value=\"POST /api/v1/transactions/deposit/{id}?valor={value}\" tabindex=\"0\" role=\"button\" style=\"display: inherit;\">\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-copy js-clipboard-copy-icon m-2\">\n" +
                "    <path d=\"M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z\"></path><path d=\"M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z\"></path>\n" +
                "</svg>\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-check js-clipboard-check-icon color-fg-success d-none m-2\">\n" +
                "    <path d=\"M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z\"></path>\n" +
                "</svg>\n" +
                "    </clipboard-copy>\n" +
                "  </div></div>\n" +
                "</li>\n" +
                "\n" +
                "<li>\n" +
                "<p dir=\"auto\">Historic</p>\n" +
                "<div class=\"snippet-clipboard-content notranslate position-relative overflow-auto\"><pre class=\"notranslate\">\n" +
                " <code>GET /api/v1/transactions/historic?data={date}\n" +
                "</code></pre><div class=\"zeroclipboard-container position-absolute right-0 top-0\">\n" +
                "    <clipboard-copy aria-label=\"Copy\" class=\"ClipboardButton btn js-clipboard-copy m-2 p-0 tooltipped-no-delay\" data-copy-feedback=\"Copied!\" data-tooltip-direction=\"w\" value=\"GET /api/v1/transactions/historic?data={date}\" tabindex=\"0\" role=\"button\" style=\"display: inherit;\">\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-copy js-clipboard-copy-icon m-2\">\n" +
                "    <path d=\"M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z\"></path><path d=\"M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z\"></path>\n" +
                "</svg>\n" +
                "      <svg aria-hidden=\"true\" height=\"16\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" data-view-component=\"true\" class=\"octicon octicon-check js-clipboard-check-icon color-fg-success d-none m-2\">\n" +
                "    <path d=\"M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z\"></path>\n" +
                "</svg>\n" +
                "    </clipboard-copy>\n" +
                "  </div></div>\n" +
                "</li>\n" +
                "\n" +
                "\n" +
                "   \n" +
                "</ul>\n";
        return html;
    }

}
