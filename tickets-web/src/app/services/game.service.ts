import {Injectable} from '@angular/core';
import {BackendService} from "./backend-service/backend.service";
import {Observable} from "rxjs";
import {Game} from "../tickets-model/game";
import {Transaction} from "../tickets-model/transaction";

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private backendService: BackendService) {
  }


  public getAllGames(): Observable<Game[]> {
    return this.backendService.get("http://localhost:8080/NBATickets/tickets-api/game");
  }

  public getTransactions(id: number): Observable<Transaction[]> {
    return this.backendService.get("http://localhost:8080/NBATickets/tickets-api/transaction/" + id);
  }

  public deleteTransaction(transaction: Transaction): Observable<any> {
    return this.backendService.put("http://localhost:8080/NBATickets/tickets-api/transaction/delete", transaction);
  }

  public addTransaction(game: Game, name: string, spots: number) {
    return this.backendService.post("http://localhost:8080/NBATickets/tickets-api/game/" + name + "/" + spots, game);
  }
}
