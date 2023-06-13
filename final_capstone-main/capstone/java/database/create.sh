#!/bin/bash
export PGPASSWORD='F2tuI0EHZAlQO8bqISDQ'
BASEDIR=$(dirname $0)
DATABASE=railway
/Applications/Postgres.app/Contents/Versions/15/bin/psql -h containers-us-west-166.railway.app -U postgres -p 6811 -d railway -f "$BASEDIR/dropdb.sql" &&
/Applications/Postgres.app/Contents/Versions/15/bin/psql -h containers-us-west-166.railway.app -U postgres -p 6811 -d railway -f "$BASEDIR/schema.sql" &&
/Applications/Postgres.app/Contents/Versions/15/bin/psql -h containers-us-west-166.railway.app -U postgres -p 6811 -d railway -f "$BASEDIR/data.sql" &&
/Applications/Postgres.app/Contents/Versions/15/bin/psql -h containers-us-west-166.railway.app -U postgres -p 6811 -d railway -f "$BASEDIR/user.sql"
