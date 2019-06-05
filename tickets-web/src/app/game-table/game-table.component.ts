import {Component, OnInit, TemplateRef} from '@angular/core';
import {GameService} from "../services/game.service";
import {Game} from "../tickets-model/game";
import {MatDialog, MatDialogConfig, MatTableDataSource} from "@angular/material";
import {Transaction} from "../tickets-model/transaction";
import {PopupComponent} from "../popup/popup.component";
import {PopupService} from "../services/popup-service/popup.service";

@Component({
  selector: 'app-game-table',
  templateUrl: './game-table.component.html',
  styleUrls: ['./game-table.component.scss']
})


export class GameTableComponent implements OnInit {
  public displayedColumns: string[] = ['match', 'stage', 'price', 'availableSpots', 'actions'];

  games: Game[];

  transactions: Transaction[];

  constructor(private gameService: GameService,
              private dialog: MatDialog,
              private popupService: PopupService) {
  }

  public dataSource: any;
  private dialogConfig;
  private loadComponent = false;

  ngOnInit() {
    this.gameService.getAllGames().subscribe(
      (games) => {
        this.games = games as Game[];
        this.dataSource = new MatTableDataSource<Game>(this.games);
      }
    )

    this.dialogConfig = new MatDialogConfig();
  }

  public transactionsDataSource: any;

  public transactionDisplayedColumns: string[] = ['gameID', 'buyerID', 'timestamp', 'delete'];

  view(id: number) {
    this.gameService.getTransactions(id).subscribe(
      (transactions) => {

        this.transactions = transactions as Transaction[];
        this.transactionsDataSource = new MatTableDataSource<Transaction>(this.transactions);
      }
    )

  }

  delete(transactions: Transaction) {
    this.gameService.deleteTransaction(transactions).subscribe(
      res => {
        console.log(res);
        this.ngOnInit();
        this.view(transactions.gameID);
      }
    );

  }

  add(component: TemplateRef<PopupComponent>, game: Game) {
    this.loadComponent = true;
    this.dialogConfig.disableClose = false;
    this.dialogConfig.autoFocus = true;
    this.dialogConfig.width = "50%";
    this.dialog.open(component, this.dialogConfig)
      .afterClosed()
      .subscribe(() =>
        this.ngOnInit()
      );
    this.popupService.viewGame(game);
    this.ngOnInit();
    this.transactionsDataSource = null;
  }
}
