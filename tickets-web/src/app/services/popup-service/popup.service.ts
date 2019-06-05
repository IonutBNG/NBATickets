import {Injectable} from '@angular/core';
import {Game} from "../../tickets-model/game";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PopupService {

  constructor() {
  }

  private game: Game;
  private gameSource = new BehaviorSubject(this.game);
  currentGame = this.gameSource.asObservable();

  viewGame(newGame: Game) {
    this.gameSource.next(newGame);
  }
}
