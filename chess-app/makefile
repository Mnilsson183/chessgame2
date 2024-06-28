make:
	mvn package

run:
	java -cp target/chess-app-1.0-SNAPSHOT.jar chess.game.app.App

count-lines:
	@echo "Counting lines of code in all Git-tracked files..."
	git ls-files | xargs wc -l