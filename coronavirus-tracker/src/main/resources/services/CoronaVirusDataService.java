package services;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;

import java.io.IOException;
import java.net.URI;

@Service
public class CoronaVirusDataService {

    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/UID_ISO_FIPS_LookUp_Table.csv";

    private List<LocationStats> allStats = new ArrayList<>();
    @PostConstruct
    @Scheduled(cron = "* * * * * *")
    public void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(VIRUS_DATA_URL))
            .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        SringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocationStats LocationStats = new LocationStats();
            locationStats.setState(record.get("Province/State"));
            locationStats.setState(record.get("Country/Region"));
            locationStats.setLatestTotalCases(Integer.parseInt(record.get(record.size() - 1)));
            newStats.add(LocationStats);
}
        this.allStats = newStats;
        
    }
}
