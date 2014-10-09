/*
 * Copyright (c) 2014 Flavien Charlon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.coinprism.model;

import android.os.AsyncTask;

public class BalanceLoader extends AsyncTask<String, Integer, AddressBalance>
{
    private WalletState parent;

    public BalanceLoader(WalletState parent)
    {
        this.parent = parent;
    }

    @Override
    protected AddressBalance doInBackground(String... addresses)
    {
        try
        {
            return parent.getAPIClient().getAddressBalance(addresses[0]);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    protected void onPostExecute(AddressBalance result)
    {
        super.onPostExecute(result);

        this.parent.updateData(result);
    }
}
