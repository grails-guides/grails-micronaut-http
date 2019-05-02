package example.grails;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client("https://itunes.apple.com/")
public interface ItunesClient {

    @Get("/search?limit=25&media=music&entity=album&term={term}")
    Single<String> search(String term);
}
