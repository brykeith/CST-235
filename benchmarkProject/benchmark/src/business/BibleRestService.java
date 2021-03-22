
package business;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import beans.Word;

@RequestScoped
@Path("/Bible")
@Produces("application/json")
@Consumes("application/json")
public class BibleRestService {
	@EJB WordFetchService wordService;

	@GET
	@Path("/wordcount/{word}")
	@Produces(MediaType.APPLICATION_JSON)
	public Word getWordOccurencesByJson(@PathParam("word") String word) {
		System.out.println("We are looking for word: " + word);
		Word w = new Word();
		w.setWord(word);
		try{
			wordService.findOccurences(w);
			if(w.getOccurences() < 0) {
				throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
			}
		return w;
		}catch(Exception e) {
			throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
